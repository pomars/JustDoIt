package com.wanby.exercise.hadoop.mr;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
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
 * Mar 16, 2018 8:23:40 PM
 */
public class AvgWordLength {

	private final static Logger LOGGER = LoggerFactory.getLogger(AvgWordLength.class);

	/**
	 *
	 * @param args
	 */
	public static void main(String[] args) throws Exception {

		if (2 != args.length) {
			LOGGER.info("Usage: AvgWordLength <input dir> <output dir>\n");
			System.exit(-1);
		}

		Job job = Job.getInstance();
		job.setJarByClass(AvgWordLength.class);
		job.setJobName("average word length");

		FileInputFormat.setInputPaths(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));

		job.setMapperClass(LetterMapper.class);
		job.setReducerClass(AverageReducer.class);

		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(IntWritable.class);

		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(DoubleWritable.class);

		boolean success = job.waitForCompletion(true);
		System.exit(success ? 0 : 1);
	}

}
