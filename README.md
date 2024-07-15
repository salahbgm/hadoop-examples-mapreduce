# hadoop-examples-mapreduce

## Send the JAR to the edge node
```
salahboughanmi@MBP-de-Salah hadoop-examples-mapreduce % scp /Users/salahboughanmi/Desktop/bigdataframework1/hadoop-examples-mapreduce/target/hadoop-examples-mapreduce-1.0-SNAPSHOT-jar-with-dependencies.jar salah.boughanmi@bigdata01.efrei.hadoop.clemlab.io:/home/salah.boughanmi/


salah.boughanmi@bigdata01.efrei.hadoop.clemlab.io's password: 
```
```
[salah.boughanmi@bigdata01 ~]$ ls
hadoop-examples-mapreduce.jar
```
## Test of wordcount on input.txt 
```
[salah.boughanmi@bigdata01 ~]$ cat input.txt


La tour Eiffel [tuʁɛfɛl] est une tour de fer puddlé de 330 m de hauteur située à Paris, à l’extrémité nord-ouest du parc du Champ-de-Mars en bordure de la Seine dans le 7ᵉ arrondissement. Son adresse officielle est 5, avenue Anatole-France.
```
```
[salah.boughanmi@bigdata01 ~]$ hdfs dfs -put /home/salah.boughanmi/input.txt /user/salah.boughanmi/
```
```
[salah.boughanmi@bigdata01 ~]$ yarn jar hadoop-examples-mapreduce.jar wordcount /user/salah.boughanmi/input.txt /user/salah.boughanmi/output-districts

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
```

## Proof of the wordcount
```
[salah.boughanmi@bigdata01 ~]$ hdfs dfs -cat /user/salah.boughanmi/output-districts/part-r-00000

#73956] 1
$5,000) 1
&   1
&c. 1
&c.;    1
($1 1
(801)   1
(SECUNDUS)  1
(This   1
(a) 1
(administrator  1
(and    1
(another    1
(any    1
```
————————————————————————————————————————————————————————————————————————————————————

# 1.8 Remarkable trees of Paris 

## Download the file and put it in your HDFS home directory.
```
salahboughanmi@MBP-de-Salah ~ % scp /Users/salahboughanmi/Downloads/trees.csv salah.boughanmi@bigdata01.efrei.hadoop.clemlab.io:/home/salah.boughanmi/
salah.boughanmi@bigdata01.efrei.hadoop.clemlab.io's password: 
trees.csv                                                                                                  100%   16KB   1.6MB/s   00:00
```
```
[salah.boughanmi@bigdata01 ~]$ hdfs dfs -put trees.csv 
[salah.boughanmi@bigdata01 ~]$ hdfs dfs -ls
Found 12 items
drwx------   - salah.boughanmi salah.boughanmi          0 2024-07-08 20:00 .Trash
drwx------   - salah.boughanmi salah.boughanmi          0 2024-07-12 16:40 .staging
drwxr-xr-x   - salah.boughanmi salah.boughanmi          0 2024-07-08 15:59 data
drwxr-xr-x   - salah.boughanmi salah.boughanmi          0 2024-07-08 16:59 gutenberg
drwxr-xr-x   - salah.boughanmi salah.boughanmi          0 2024-07-08 17:06 gutenberg-output
drwxr-xr-x   - salah.boughanmi salah.boughanmi          0 2024-07-08 17:49 gutenberg-output2
-rw-r--r--   3 salah.boughanmi salah.boughanmi        253 2024-07-12 16:39 input.txt
-rw-r--r--   3 salah.boughanmi salah.boughanmi     118577 2024-07-08 14:51 livre.txt
drwxr-xr-x   - salah.boughanmi salah.boughanmi          0 2024-07-12 16:40 output-districts
drwxr-xr-x   - salah.boughanmi salah.boughanmi          0 2024-07-08 11:52 raw
-rw-r--r--   3 salah.boughanmi salah.boughanmi      16680 2024-07-15 09:26 trees.csv
drwxr-xr-x   - salah.boughanmi salah.boughanmi          0 2024-07-08 15:36 wordcount
```
```
[salah.boughanmi@bigdata01 ~]$ hdfs dfs -cat trees.csv 
GEOPOINT;ARRONDISSEMENT;GENRE;ESPECE;FAMILLE;ANNEE PLANTATION;HAUTEUR;CIRCONFERENCE;ADRESSE;NOM COMMUN;VARIETE;OBJECTID;NOM_EV
(48.857140829, 2.29533455314);7;Maclura;pomifera;Moraceae;1935;13.0;;Quai Branly, avenue de La Motte-Piquet, avenue de la Bourdonnais, avenue de Suffren;Oranger des Osages;;6;Parc du Champs de Mars
(48.8685686134, 2.31331809304);8;Calocedrus;decurrens;Cupressaceae;1854;20.0;195.0;Cours-la-Reine, avenue Franklin-D.-Roosevelt, avenue Matignon, avenue Gabriel;Cèdre à encens;;11;Jardin des Champs Elysées
(48.8768191638, 2.33210374339);9;Pterocarya;fraxinifolia;Juglandaceae;1862;22.0;330.0;Place d'Estienne-d'Orves;Pérocarya du Caucase;;14;Square Etienne d'Orves
(48.8373323894, 2.40776275516);12;Celtis;australis;Cannabaceae;1906;16.0;295.0;27, boulevard Soult;Micocoulier de Provence;;16;Avenue 27 boulevard Soult
(48.8341842636, 2.46130493573);12;Quercus;petraea;Fagaceae;1784;30.0;430.0;route ronde des Minimes;Chêne rouvre;;19;Bois de Vincennes (lac des minimes)
(48.8325900983, 2.41116455985);12;Platanus;x acerifolia;Platanaceae;1860;45.0;405.0;Ile de Bercy;Platane commun;;21;Bois de Vincennes (Ile de Bercy)
(48.8226749117, 2.33869560229);14;Platanus;x acerifolia;Platanaceae;1840;40.0;580.0;Bd Jourdan, avenue Reille, rue Gazan, rue de la Cité‚-Universitaire, rue Nansouty;Platane commun;;26;Parc Montsouris
(48.8428118006, 2.2972574926);15;Alnus;glutinosa;Betulaceae;1933;16.0;220.0;Rue Th‚ophraste-Renaudot, rue L‚on-Lhermitte, rue Jean Formig‚, rue du Docteur Jacquem;Aulne glutineux;;28;Square Saint Lambert
(48.8717782491, 2.27973325759);16;Aesculus;hippocastanum;Sapindaceae;;30.0;505.0;Avenue Foch;Marronnier d'Inde;;30;Avenue Foch
(48.8802898189, 2.38157469859);19;Ginkgo;biloba;Ginkgoaceae;1913;33.0;230.0;Rue Manin, rue Botzaris;Arbre aux quarante écus;;46;Parc des Buttes Chaumont
```

**import on the edge the new hadoop-examples-mapreduce.jar with all the app**
```
salahboughanmi@MacBook-Pro-de-Salah ~ % scp /Users/salahboughanmi/Desktop/bigdataframework1/hadoop-examples-mapreduce/hadoop-examples-mapreduce.jar salah.boughanmi@bigdata01.efrei.hadoop.clemlab.io:/home/salah.boughanmi/
salah.boughanmi@bigdata01.efrei.hadoop.clemlab.io's password: 
hadoop-examples-mapreduce.jar                 100%   57MB  10.9MB/s   00:05 
```
```

[salah.boughanmi@bigdata01 ~]$ ls
bonjour.txt                    livre.txt     message          reducer_up.py                         The_Outline_of_Science.txt
demat.txt                      local.txt     mon_fichier.txt  secret-of-the-universe.txt            trees.csv
hadoop-examples-mapreduce.jar  mapper.py     poetry           sudoku.dta                            Ulysses_by_JamesJoyce.txt
input.txt                      mapper_up.py  reducer.py       The_Notebooks_of_LeonardoDaVinci.txt
```


## 1.8.1 Districts containing trees (very easy)

```
[salah.boughanmi@bigdata01 ~]$ yarn jar hadoop-examples-mapreduce.jar districts /user/salah.boughanmi/trees.csv /user/salah.boughanmi/Districtscontainingtrees

24/07/15 11:02:38 INFO mapreduce.Job: Counters: 54
	File System Counters
		FILE: Number of bytes read=477
		FILE: Number of bytes written=612733
		FILE: Number of read operations=0
		FILE: Number of large read operations=0
		FILE: Number of write operations=0
		HDFS: Number of bytes read=16788
		HDFS: Number of bytes written=44
		HDFS: Number of read operations=8
		HDFS: Number of large read operations=0
		HDFS: Number of write operations=2
		HDFS: Number of bytes read erasure-coded=0
	Job Counters 
		Launched map tasks=1
		Launched reduce tasks=1
		Data-local map tasks=1
		Total time spent by all maps in occupied slots (ms)=11388
		Total time spent by all reduces in occupied slots (ms)=5516
		Total time spent by all map tasks (ms)=3796
		Total time spent by all reduce tasks (ms)=1379
		Total vcore-milliseconds taken by all map tasks=3796
		Total vcore-milliseconds taken by all reduce tasks=1379
		Total megabyte-milliseconds taken by all map tasks=5830656
		Total megabyte-milliseconds taken by all reduce tasks=2824192
	Map-Reduce Framework
		Map input records=98
		Map output records=97
		Map output bytes=277
		Map output materialized bytes=477
		Input split bytes=108
		Combine input records=0
		Combine output records=0
		Reduce input groups=17
		Reduce shuffle bytes=477
		Reduce input records=97
		Reduce output records=17
		Spilled Records=194
		Shuffled Maps =1
		Failed Shuffles=0
		Merged Map outputs=1
		GC time elapsed (ms)=73
		CPU time spent (ms)=1120
		Physical memory (bytes) snapshot=1544126464
		Virtual memory (bytes) snapshot=6699347968
		Total committed heap usage (bytes)=1597505536
		Peak Map Physical memory (bytes)=1198366720
		Peak Map Virtual memory (bytes)=3111907328
		Peak Reduce Physical memory (bytes)=345759744
		Peak Reduce Virtual memory (bytes)=3587440640
	Shuffle Errors
		BAD_ID=0
		CONNECTION=0
		IO_ERROR=0
		WRONG_LENGTH=0
		WRONG_MAP=0
		WRONG_REDUCE=0
	File Input Format Counters 
		Bytes Read=16680
	File Output Format Counters 
		Bytes Written=44
```

**Check the output**
```
[salah.boughanmi@bigdata01 ~]$ hdfs dfs -ls
Found 13 items
drwx------   - salah.boughanmi salah.boughanmi          0 2024-07-08 20:00 .Trash
drwx------   - salah.boughanmi salah.boughanmi          0 2024-07-15 11:02 .staging
drwxr-xr-x   - salah.boughanmi salah.boughanmi          0 2024-07-15 11:02 Districtscontainingtrees
-rw-r--r--   3 salah.boughanmi salah.boughanmi      16680 2024-07-15 09:26 trees.csv

[salah.boughanmi@bigdata01 ~]$ hdfs dfs -ls Districtscontainingtrees
Found 2 items
-rw-r--r--   3 salah.boughanmi salah.boughanmi          0 2024-07-15 11:02 Districtscontainingtrees/_SUCCESS
-rw-r--r--   3 salah.boughanmi salah.boughanmi         44 2024-07-15 11:02 Districtscontainingtrees/part-r-00000


[salah.boughanmi@bigdata01 ~]$ hdfs dfs -cat Districtscontainingtrees/part-r-00000
11
12
13
14
15
16
17
18
19
20
3
4
5
6
7
8
9
```





## 1.8.2 Show all existing species (very easy)







## 1.8.3 Number of trees by kinds (easy)






## 1.8.4 Maximum height per kind of tree (average)





## 1.8.5 Sort the trees height from smallest to largest (average)





## 1.8.6 District containing the oldest tree (difficult)



## 1.8.7 District containing the most trees (very difficult)




