package com.opstty.mapper;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class HeightSortMapper extends Mapper<LongWritable, Text, FloatWritable, Text> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();
        if (line.startsWith("ID")) {
            // Skip the header line
            return;
        }
        String[] fields = line.split(";");
        if (fields.length > 3) { // Remplace 3 par l'index correct pour la hauteur
            try {
                float height = Float.parseFloat(fields[3]);
                context.write(new FloatWritable(height), value);
            } catch (NumberFormatException e) {
                // Ignorer les lignes où la hauteur n'est pas un nombre
            }
        }
    }
}
