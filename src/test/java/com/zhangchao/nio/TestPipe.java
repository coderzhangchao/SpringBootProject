package com.zhangchao.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

import org.junit.Test;

/**
 * Java NIO 管道是2个线程之间的单向数据连接。
 * Pipe有一个source通道和一个sink通道。
 * 数据会被写到sink通道，从source通道读取。
 * @author fmr
 */
public class TestPipe {
	
	/**
	 * 测试向管道中写入数据
	 * @throws IOException
	 */
	@Test
	public void testWrite() throws IOException{
		String str = "测试写入的数据";
		//创建管道
		Pipe pipe = Pipe.open();
		
		//向管道写输入
		Pipe.SinkChannel sinkChannel =  pipe.sink();
		
		//通过SinkChannel的write方法写数据
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		buffer.put(str.getBytes());
		buffer.flip();
		while(buffer.hasRemaining()) {
			System.out.println("进来了...");
			sinkChannel.write(buffer);
		}
		
		//从管道读取数据
		Pipe.SourceChannel sourceChannel = pipe.source();
		buffer.flip();
		int len = sourceChannel.read(buffer);
		System.out.println(new String(buffer.array(), 0, len));
		
		sourceChannel.close();
		sinkChannel.close();
	}
	
	@Test
	public void test1() throws IOException{
		//1. 获取管道
		Pipe pipe = Pipe.open();
		
		//2. 将缓冲区中的数据写入管道
		ByteBuffer buf = ByteBuffer.allocate(1024);
		
		Pipe.SinkChannel sinkChannel = pipe.sink();
		buf.put("通过单向管道发送数据".getBytes());
		buf.flip();
		sinkChannel.write(buf);
		
		//3. 读取缓冲区中的数据
		Pipe.SourceChannel sourceChannel = pipe.source();
		buf.flip();
		int len = sourceChannel.read(buf);
		System.out.println(new String(buf.array(), 0, len));
		
		sourceChannel.close();
		sinkChannel.close();
	}
	
}
