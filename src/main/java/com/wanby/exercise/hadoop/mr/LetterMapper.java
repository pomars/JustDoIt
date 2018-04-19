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
 * Mar 16, 2018 8:49:40 PM
 */
public class LetterMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

	@Override
	protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

		String line = value.toString();

		for (String word : line.split("\\W+")) {
			if (word.length() > 0) {
				context.write(new Text(word.substring(0, 1)), new IntWritable(word.length()));
			}
		}
	}
}
