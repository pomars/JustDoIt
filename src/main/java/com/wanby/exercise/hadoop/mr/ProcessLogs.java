package com.wanby.exercise.hadoop.mr;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @Author wanby
 * @Version 1.0.00
 * Apr 2, 2018 7:35:11 PM
 */
public class ProcessLogs {
	private final static Logger LOGGER = LoggerFactory.getLogger(ProcessLogs.class);

	public static void main(String[] args) throws Exception {

		if (2 != args.length) {
			LOGGER.info("Usage:ProcessLogs <input dir> <output dir>\n");
			System.exit(-1);
		}

		Job job = Job.getInstance();
		job.setJarByClass(ProcessLogs.class);
		job.setJobName("count the number of hits");

		FileInputFormat.setInputPaths(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));

		job.setMapperClass(LogFileMapper.class);
		job.setReducerClass(SumReducer.class);

		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(IntWritable.class);

		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(LongWritable.class);
		
		boolean sucess = job.waitForCompletion(true);
		System.exit(sucess ? 0 : 1);

	}

}
