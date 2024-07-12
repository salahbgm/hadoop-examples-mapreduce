package com.opstty.mapper;

import com.opstty.writable.AgeDistrictWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class OldestTreeMapper extends Mapper<LongWritable, Text, Text, AgeDistrictWritable> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();
        if (line.startsWith("ID")) {
            // Skip the header line
            return;
        }
        String[] fields = line.split(";");
        if (fields.length > 4) { // Remplace 4 par l'index correct pour l'âge
            try {
                int age = Integer.parseInt(fields[4]);
                String district = fields[1]; // Remplace 1 par l'index correct pour l'arrondissement
                context.write(new Text("oldest"), new AgeDistrictWritable(age, district));
            } catch (NumberFormatException e) {
                // Ignorer les lignes où l'âge n'est pas un nombre
            }
        }
    }
}
