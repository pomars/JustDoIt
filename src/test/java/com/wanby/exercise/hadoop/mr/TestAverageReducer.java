package com.wanby.exercise.hadoop.mr;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mrunit.mapreduce.ReduceDriver;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @Author wanby
 * @Version 1.0.00 Apr 8, 2018 7:00:15 PM
 */
public class TestAverageReducer {
	ReduceDriver<Text, IntWritable, Text, DoubleWritable> reduceDriver;

	@Before
	public void setUp() {
		AverageReducer averageReducer = new AverageReducer();
		reduceDriver = new ReduceDriver<Text, IntWritable, Text, DoubleWritable>();
		reduceDriver.setReducer(averageReducer);
	}

	@Test
	public void testReducer() throws IOException {
		List<IntWritable> values = Arrays.asList(new IntWritable(3), new IntWritable(3), new IntWritable(4));
		reduceDriver.withInput(new Text("C"), values);
		reduceDriver.withOutput(new Text("C"), new DoubleWritable((double) 10 / 3));
		reduceDriver.runTest();
	}
}
