package com.wanby.exercise.hadoop.mr;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mrunit.mapreduce.MapDriver;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @Author wanby
 * @Version 1.0.00
 * Apr 4, 2018 3:31:40 PM
 */
public class TestLetterMapper {
	MapDriver<LongWritable, Text, Text, IntWritable> mapDriver;

	@Before
	public void setUp() {
		LetterMapper lMapper = new LetterMapper();
		mapDriver = new MapDriver<LongWritable, Text, Text, IntWritable>();
		mapDriver.setMapper(lMapper);
	}

	@Test
	public void testMapper() throws IOException {
		mapDriver.withInput(new LongWritable(1), new Text("Cat dog dig cap dump"));
		mapDriver.withOutput(new Text("C"), new IntWritable(3));
		mapDriver.withOutput(new Text("d"), new IntWritable(3));
		mapDriver.withOutput(new Text("d"), new IntWritable(3));
		mapDriver.withOutput(new Text("c"), new IntWritable(3));
		mapDriver.withOutput(new Text("d"), new IntWritable(4));
		mapDriver.runTest();
	}
}
