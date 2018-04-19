package com.wanby.exercise.hadoop.mr;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

/**
 * 
 * @Author wanby
 * @Version 1.0.00
 * Apr 2, 2018 7:45:00 PM
 */
public class LogFileMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {

		String line = value.toString();
		context.write(new Text(line.split(" ")[0]), new IntWritable(1));

	}

}
