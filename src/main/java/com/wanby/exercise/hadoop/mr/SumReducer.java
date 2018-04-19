package com.wanby.exercise.hadoop.mr;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

/**
 * 
 * @Author wanby
 * @Version 1.0.00
 * Apr 2, 2018 8:31:55 PM
 */
public class SumReducer extends Reducer<Text, IntWritable, Text, LongWritable> {

	@Override
	protected void reduce(Text text, Iterable<IntWritable> values, Context context)
			throws IOException, InterruptedException {

		int sum = 0;
		for (IntWritable value : values) {
			sum += value.get();
		}
		context.write(text, new LongWritable(sum));
	}

}
