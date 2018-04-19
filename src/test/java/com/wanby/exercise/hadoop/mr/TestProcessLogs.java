package com.wanby.exercise.hadoop.mr;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mrunit.mapreduce.MapReduceDriver;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @Author wanby
 * @Version 1.0.00 Apr 9, 2018 8:47:41 PM
 */
public class TestProcessLogs {
	MapReduceDriver<LongWritable, Text, Text, IntWritable, Text, LongWritable> mapReduceDriver;

	@Before
	public void setUp() {
		LogFileMapper logFileMapper = new LogFileMapper();
		SumReducer sumReducer = new SumReducer();
		mapReduceDriver = MapReduceDriver.newMapReduceDriver(logFileMapper, sumReducer);
	}

	@Test
	public void testMapReducer() throws IOException {
		mapReduceDriver.withInput(new LongWritable(1), new Text("10.2.68.99 http test1"));
		mapReduceDriver.withInput(new LongWritable(1), new Text("10.2.68.99 http test2"));
		mapReduceDriver.withOutput(new Text("10.2.68.99"), new LongWritable(2));
		mapReduceDriver.runTest();
	}
}
