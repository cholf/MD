### Anwser

```
- BIO是每次request服务器都会分配一个线程，所以，当某个线程发生IO阻塞的时候，该线程就无法充分利用。而NIO则是服务器会不断的轮询每一个client发送的request，如果有N个可读状态的request，OK，那服务器就会分配N个线程去读，这就是非阻塞。
- 每个request会封装一个channel，将所有的channel注册在一个Selector上，然后selector开始不断的轮询每个request的可读状态，如果可读，则直接返回可读状态的channel。
- 不断轮询可读状态的，if(n==0)continue;如果可读状态的个数n为0，则继续轮询，这句话就是这个意思。（阻塞selector.select()）
```
