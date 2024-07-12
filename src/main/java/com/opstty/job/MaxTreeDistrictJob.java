
package com.opstty.job;

import com.opstty.mapper.MaxTreeDistrictMapper;
import com.opstty.reducer.MaxTreeDistrictReducer;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class MaxTreeDistrictJob {
    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf, "District containing the most trees - Phase 2");
        job.setJarByClass(MaxTreeDistrictJob.class);
        job.setMapperClass(MaxTreeDistrictMapper.class);
        job.setReducerClass(MaxTreeDistrictReducer.class);
        job.setOutputKeyClass(NullWritable.class);
        job.setOutputValueClass(Text.class);
        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}
