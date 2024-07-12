## hadoop-examples-mapreduce

# Send the JAR to the edge node
** salahboughanmi@MBP-de-Salah hadoop-examples-mapreduce % scp /Users/salahboughanmi/Desktop/bigdataframework1/hadoop-examples-mapreduce/target/hadoop-examples-mapreduce-1.0-SNAPSHOT-jar-with-dependencies.jar salah.boughanmi@bigdata01.efrei.hadoop.clemlab.io:/home/salah.boughanmi/ **

salah.boughanmi@bigdata01.efrei.hadoop.clemlab.io's password: 

** [salah.boughanmi@bigdata01 ~]$ ls ** 
hadoop-examples-mapreduce.jar

# Test of wordcount on input.txt 
** [salah.boughanmi@bigdata01 ~]$ cat input.txt **
La tour Eiffel [tuʁɛfɛl] est une tour de fer puddlé de 330 m de hauteur située à Paris, à l’extrémité nord-ouest du parc du Champ-de-Mars en bordure de la Seine dans le 7ᵉ arrondissement. Son adresse officielle est 5, avenue Anatole-France


** [salah.boughanmi@bigdata01 ~]$ yarn jar hadoop-examples-mapreduce.jar wordcount /user/salah.boughanmi/input.txt /user/salah.boughanmi/output-districts **
24/07/12 16:40:39 INFO mapreduce.Job: Running job: job_1720701352744_0528
24/07/12 16:40:45 INFO mapreduce.Job: Job job_1720701352744_0528 running in uber mode : false
24/07/12 16:40:45 INFO mapreduce.Job:  map 0% reduce 0%
24/07/12 16:40:51 INFO mapreduce.Job:  map 100% reduce 0%
24/07/12 16:40:54 INFO mapreduce.Job:  map 100% reduce 100%
24/07/12 16:40:54 INFO mapreduce.Job: Job job_1720701352744_0528 completed successfully
24/07/12 16:40:54 INFO mapreduce.Job: Counters: 54
	File System Counters
		FILE: Number of bytes read=90154
		FILE: Number of bytes written=1099144
		FILE: Number of read operations=0
		FILE: Number of large read operations=0
		FILE: Number of write operations=0
		HDFS: Number of bytes read=64714
		HDFS: Number of bytes written=64691
		HDFS: Number of read operations=11
		HDFS: Number of large read operations=0
		HDFS: Number of write operations=2
		HDFS: Number of bytes read erasure-coded=0
	Job Counters 
		Launched map tasks=2
		Launched reduce tasks=1
		Data-local map tasks=2
		Total time spent by all maps in occupied slots (ms)=22908
		Total time spent by all reduces in occupied slots (ms)=5512
		Total time spent by all map tasks (ms)=7636
		Total time spent by all reduce tasks (ms)=1378
		Total vcore-milliseconds taken by all map tasks=7636
		Total vcore-milliseconds taken by all reduce tasks=1378
		Total megabyte-milliseconds taken by all map tasks=11728896
		Total megabyte-milliseconds taken by all reduce tasks=2822144
	Map-Reduce Framework
		Map input records=6265
		Map output records=12569
		Map output bytes=114761
		Map output materialized bytes=90160
		Input split bytes=229
		Combine input records=12569
		Combine output records=6368
		Reduce input groups=6367
		Reduce shuffle bytes=90160
		Reduce input records=6368
		Reduce output records=6367
		Spilled Records=12736
		Shuffled Maps =2
		Failed Shuffles=0
		Merged Map outputs=2
		GC time elapsed (ms)=114
		CPU time spent (ms)=2470
		Physical memory (bytes) snapshot=2771296256
		Virtual memory (bytes) snapshot=9823965184
		Total committed heap usage (bytes)=2792882176
		Peak Map Physical memory (bytes)=1221087232
		Peak Map Virtual memory (bytes)=3118125056
		Peak Reduce Physical memory (bytes)=351076352
		Peak Reduce Virtual memory (bytes)=3592835072
	Shuffle Errors
		BAD_ID=0
		CONNECTION=0
		IO_ERROR=0
		WRONG_LENGTH=0
		WRONG_MAP=0
		WRONG_REDUCE=0
	File Input Format Counters 
		Bytes Read=64485
	File Output Format Counters 
		Bytes Written=64691

————————————————————————————————————————————————————————————————————————————————————
