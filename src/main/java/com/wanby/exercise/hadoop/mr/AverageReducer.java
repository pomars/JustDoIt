package com.wanby.exercise.hadoop.mr;

import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

/**
 * 
 * @Author wanby
 * @Version 1.0.00
 * Mar 16, 2018 9:11:40 PM
 */
public class AverageReducer extends Reducer<Text, IntWritable, Text, DoubleWritable> {

	@Override
	protected void reduce(Text key, Iterable<IntWritable> values, Context context)
			throws IOException, InterruptedException {
		long sum = 0;
		long count = 0;
		for (IntWritable value : values) {
			sum += value.get();
			count++;
		}
		if (0 != count) {
			double result = (double) sum / (double) count;
			context.write(key, new DoubleWritable(result));
		}
	}

}
