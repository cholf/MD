public  String readFile(String fName, long start, int len)
    throws Exception {
  RandomAccessFile raf = new RandomAccessFile(fName, "rw");
  byte src[] = new byte[len];
  // 文件读完返回为null
  if (raf.length() < start + len)
    return null;
  FileChannel channel = raf.getChannel();
  MappedByteBuffer buffer = channel.map(FileChannel.MapMode.READ_ONLY,
      start, len);
  for (int i = 0; i < len; i++) {
    if (buffer.get(i) != 0) {
      src[i] = buffer.get(i);
    }
  }
  buffer.clear();
  channel.close();
  raf.close();
  return new String(src,0,len);
}
