package com.opstty.mapper;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class TreeCountMapper extends Mapper<Object, Text, Text, IntWritable> {
    private Text species = new Text();
    private final static IntWritable one = new IntWritable(1);

    @Override
    protected void map(Object key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();
        if (line.startsWith("ID")) {
            // Skip the header line
            return;
        }
        String[] fields = line.split(";");
        if (fields.length > 2) { // Remplace 2 par l'index correct pour l'espèce
            species.set(fields[2]);
            context.write(species, one);
        }
    }
}
