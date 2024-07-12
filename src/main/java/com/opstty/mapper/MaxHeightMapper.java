package com.opstty.mapper;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class MaxHeightMapper extends Mapper<Object, Text, Text, FloatWritable> {
    private Text species = new Text();
    private FloatWritable height = new FloatWritable();

    @Override
    protected void map(Object key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();
        if (line.startsWith("ID")) {
            // Skip the header line
            return;
        }
        String[] fields = line.split(";");
        if (fields.length > 3) { // Remplace 2 par l'index correct pour l'espèce et 3 par l'index correct pour la hauteur
            species.set(fields[2]);
            height.set(Float.parseFloat(fields[3]));
            context.write(species, height);
        }
    }
}
