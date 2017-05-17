## NIO
- Channels
  - FileChannel
  - DatagramChannel
  - SocketChannel
  - ServerSocketChannel
___
- Buffers(基本类型)

***
- Selectors
![](nio-selectors.png)
-
```
Selector selector = Selector.open();//create
channel.configureBlocking(false);
SelectionKey key = channel.register(selector, SelectionKey.OP_READ);//register
while(true) {//for(::)-which-better
  int readyChannels = selector.select();
  if(readyChannels == 0) continue;
  Set<SelectionKey> selectedKeys = selector.selectedKeys();
  Iterator<SelectionKey> keyIterator = selectedKeys.iterator();
  while(keyIterator.hasNext()) {
    SelectionKey key = keyIterator.next();
    if(key.isAcceptable()) {
        // a connection was accepted by a ServerSocketChannel.
    } else if (key.isConnectable()) {
        // a connection was established with a remote server.
    } else if (key.isReadable()) {
        // a channel is ready for reading
    } else if (key.isWritable()) {
        // a channel is ready for writing
    }
    keyIterator.remove();
  }
}
```
