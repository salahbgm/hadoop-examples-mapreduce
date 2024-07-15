package com.opstty.mapper;

import java.io.IOException;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class MaxHeightMapper extends Mapper<LongWritable, Text, Text, FloatWritable> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        if (key.get() == 0) return; // Ignorer la première ligne
        String[] fields = value.toString().split(";");
        String species = fields[3]; // Supposons que l'espèce est dans la quatrième colonne
        float height = Float.parseFloat(fields[6]); 
        context.write(new Text(species), new FloatWritable(height));
    }
}
