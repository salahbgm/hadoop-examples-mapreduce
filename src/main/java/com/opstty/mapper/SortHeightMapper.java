package com.opstty.mapper;
import java.io.IOException;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class SortHeightMapper extends Mapper<LongWritable, Text, FloatWritable, Text> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        if (key.get() == 0) return; // Ignorer la première ligne
        String[] fields = value.toString().split(";");
        float height = Float.parseFloat(fields[6]); // Supposons que la hauteur est dans la septième colonne
        context.write(new FloatWritable(height), value);
    }
}
