package me.sigh.step.io.nio;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.CharBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by wangtingbang on 2017/3/1.
 */
public class NIOBasic {

  public static void main(String[] argv){
    CharBuffer charBuffer;
    ServerSocketChannel channel;

    Selector selector = null;
    SelectionKey selectionKey = null;
    ServerSocketChannel serverSocketChannel = null;
    InetSocketAddress address = new InetSocketAddress("localhost", 9000);
    try {
      selector = Selector.open();
    }catch (Exception e){
      e.printStackTrace();
      return;
    }
    try{
      serverSocketChannel = ServerSocketChannel.open();
    }catch (Exception e){
      e.printStackTrace();
      return;
    }
    try {
      serverSocketChannel.socket().bind(address);
      serverSocketChannel.configureBlocking(false);
    }catch (Exception e){
      e.printStackTrace();
      if(serverSocketChannel!=null) {
        try {
          serverSocketChannel.close();
        } catch (Exception ee) {
          e.printStackTrace();
        }
      }
      return;
    }

    try {
      selectionKey = serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
    }catch (Exception e){
      e.printStackTrace();
      if(serverSocketChannel!=null) {
        try {
          serverSocketChannel.close();
        } catch (Exception ee) {
          e.printStackTrace();
        }
      }
      return;
    }

    int channels = 0;

    System.out.println("start ok");

    while (true){
      try {
        int keyNum = selector.select();
        if(keyNum>0){
          Set<SelectionKey> keys = selector.selectedKeys();
          Iterator<SelectionKey> iterator = keys.iterator();
          while(iterator.hasNext()){
            SelectionKey key = iterator.next();
            iterator.remove();
            if(key.isAcceptable()){
              SelectableChannel selectableChannel = key.channel();
              Socket socket = ((ServerSocketChannel)key.channel()).accept().socket();
              SocketChannel sc = socket.getChannel();
//              sc.configureBlocking(false);
//              sc.register(selector, SelectionKey.OP_READ |SelectionKey.OP_WRITE);


              System.out.println("acceptable");
              System.out.println(++channels);
            }else if(key.isReadable()){
              System.out.println("readable");
            }else if(key.isWritable()){
              System.out.println("writable");
            }
            else{
              System.out.println("notable");
            }
          }
        }else{
          System.out.println("selectors.select <= 0");
        }
      }catch (Exception e){
        e.printStackTrace();
        continue;
      }
    }

  }
}
