## Lab 5


# Multithreaded Matrix Multiplication


## Operation System

[22/11/2022]


## Lecture By **Professor Kor Sokchea **


## Reported By **MISA Pisatto**

Contents



* Introduction
* Objective
* Implementation
* Testing And Result
* Conclusion


## Introduction

	Since day to day, CPU performance is increasing quickly. In the CPU industry engineers are trying to develop a CPU with less power consumption and high performance of processor speed. As we noted from old generation to new generation of CPU they mainly have increased the clock speed (frequency) and number of threads. It means a program which can process with multiple threads will reduce the duration time of processing.


## Objective

	This testing report is mainly created in order to observe the benefit of implementing threads execution in multiplication of matrices.


## Implementation

	This matrix multiplication program I have implemented thread execution. I have split the task into small threads. Every thread has its own specific task to calculate a row of matrix answers.

	For instance, We have a x b of matrix multiple * b x c of the matrix so the number of tasks is the row number of a x b. (Number of tasks = a)


## Testing And Result

	I have tested with two computers. The first is the M1 cpu which has 8 cores  (4 cores 3.2GHz - 4 cores 2GHz). I have tested this machine with two conditions, once single core and 7 cores. As we can see in the data sheet running in 7 threads is on average 2.8 times faster than a single core. If we take a look at 19 threads of intel core i7 we found that it is faster than a single core on average 17.3 times.


<table>
  <tr>
   <td>condition
   </td>
   <td>M1 - (1 core 3.2GHz)
   </td>
   <td>M1 - (4 cores 3.2GHz - 4 cores 2GHz)
   </td>
   <td>M1 - 1thread VS 7threads
   </td>
   <td>Intel i7 12700K (20 cores)
   </td>
   <td>M1 - 1thread VS intel core i7 20threads
   </td>
  </tr>
  <tr>
   <td>rows x columns
   </td>
   <td>1 threads
   </td>
   <td>7 threads
   </td>
   <td>duration (1core / 7cores)
   </td>
   <td>19 threads
   </td>
   <td>duration (1core / 19cores)
   </td>
  </tr>
  <tr>
   <td>1000 x 1000
   </td>
   <td><p style="text-align: right">
1277</p>

   </td>
   <td><p style="text-align: right">
497</p>

   </td>
   <td><p style="text-align: right">
2.6</p>

   </td>
   <td><p style="text-align: right">
186</p>

   </td>
   <td><p style="text-align: right">
6.9</p>

   </td>
  </tr>
  <tr>
   <td>1300 x 1300
   </td>
   <td><p style="text-align: right">
2774</p>

   </td>
   <td><p style="text-align: right">
953</p>

   </td>
   <td><p style="text-align: right">
2.9</p>

   </td>
   <td><p style="text-align: right">
152</p>

   </td>
   <td><p style="text-align: right">
18.3</p>

   </td>
  </tr>
  <tr>
   <td>1600 x 1600
   </td>
   <td><p style="text-align: right">
5178</p>

   </td>
   <td><p style="text-align: right">
1712</p>

   </td>
   <td><p style="text-align: right">
3.0</p>

   </td>
   <td><p style="text-align: right">
275</p>

   </td>
   <td><p style="text-align: right">
18.8</p>

   </td>
  </tr>
  <tr>
   <td>1900 x 1900
   </td>
   <td><p style="text-align: right">
8879</p>

   </td>
   <td><p style="text-align: right">
2998</p>

   </td>
   <td><p style="text-align: right">
3.0</p>

   </td>
   <td><p style="text-align: right">
487</p>

   </td>
   <td><p style="text-align: right">
18.2</p>

   </td>
  </tr>
  <tr>
   <td>2200 x 2200
   </td>
   <td><p style="text-align: right">
14037</p>

   </td>
   <td><p style="text-align: right">
6390</p>

   </td>
   <td><p style="text-align: right">
2.2</p>

   </td>
   <td><p style="text-align: right">
770</p>

   </td>
   <td><p style="text-align: right">
18.2</p>

   </td>
  </tr>
  <tr>
   <td>2500 x 2500
   </td>
   <td><p style="text-align: right">
20345</p>

   </td>
   <td><p style="text-align: right">
8251</p>

   </td>
   <td><p style="text-align: right">
2.5</p>

   </td>
   <td><p style="text-align: right">
1149</p>

   </td>
   <td><p style="text-align: right">
17.7</p>

   </td>
  </tr>
  <tr>
   <td>2800 x 2800
   </td>
   <td><p style="text-align: right">
28708</p>

   </td>
   <td><p style="text-align: right">
10878</p>

   </td>
   <td><p style="text-align: right">
2.6</p>

   </td>
   <td><p style="text-align: right">
1578</p>

   </td>
   <td><p style="text-align: right">
18.2</p>

   </td>
  </tr>
  <tr>
   <td>3100 x 3100
   </td>
   <td><p style="text-align: right">
38865</p>

   </td>
   <td><p style="text-align: right">
13015</p>

   </td>
   <td><p style="text-align: right">
3.0</p>

   </td>
   <td><p style="text-align: right">
2118</p>

   </td>
   <td><p style="text-align: right">
18.3</p>

   </td>
  </tr>
  <tr>
   <td>3400 x 3400
   </td>
   <td><p style="text-align: right">
50613</p>

   </td>
   <td><p style="text-align: right">
17777</p>

   </td>
   <td><p style="text-align: right">
2.8</p>

   </td>
   <td><p style="text-align: right">
2803</p>

   </td>
   <td><p style="text-align: right">
18.1</p>

   </td>
  </tr>
  <tr>
   <td>3700 x 3700
   </td>
   <td><p style="text-align: right">
65006</p>

   </td>
   <td><p style="text-align: right">
21946</p>

   </td>
   <td><p style="text-align: right">
3.0</p>

   </td>
   <td><p style="text-align: right">
3684</p>

   </td>
   <td><p style="text-align: right">
17.6</p>

   </td>
  </tr>
  <tr>
   <td>4000 x 4000
   </td>
   <td><p style="text-align: right">
82238</p>

   </td>
   <td><p style="text-align: right">
28364</p>

   </td>
   <td><p style="text-align: right">
2.9</p>

   </td>
   <td><p style="text-align: right">
4597</p>

   </td>
   <td><p style="text-align: right">
17.9</p>

   </td>
  </tr>
  <tr>
   <td>4300 x 4300
   </td>
   <td><p style="text-align: right">
101560</p>

   </td>
   <td><p style="text-align: right">
35193</p>

   </td>
   <td><p style="text-align: right">
2.9</p>

   </td>
   <td><p style="text-align: right">
5772</p>

   </td>
   <td><p style="text-align: right">
17.6</p>

   </td>
  </tr>
  <tr>
   <td>4600 x 4600
   </td>
   <td><p style="text-align: right">
124524</p>

   </td>
   <td><p style="text-align: right">
42776</p>

   </td>
   <td><p style="text-align: right">
2.9</p>

   </td>
   <td><p style="text-align: right">
7166</p>

   </td>
   <td><p style="text-align: right">
17.4</p>

   </td>
  </tr>
  <tr>
   <td>4900 x 4900
   </td>
   <td><p style="text-align: right">
150364</p>

   </td>
   <td><p style="text-align: right">
55035</p>

   </td>
   <td><p style="text-align: right">
2.7</p>

   </td>
   <td><p style="text-align: right">
8586</p>

   </td>
   <td><p style="text-align: right">
17.5</p>

   </td>
  </tr>
  <tr>
   <td>5200 x 5200
   </td>
   <td><p style="text-align: right">
179393</p>

   </td>
   <td><p style="text-align: right">
64720</p>

   </td>
   <td><p style="text-align: right">
2.8</p>

   </td>
   <td><p style="text-align: right">
10345</p>

   </td>
   <td><p style="text-align: right">
17.3</p>

   </td>
  </tr>
  <tr>
   <td>5500 x 5500
   </td>
   <td><p style="text-align: right">
219377</p>

   </td>
   <td><p style="text-align: right">
81555</p>

   </td>
   <td><p style="text-align: right">
2.7</p>

   </td>
   <td><p style="text-align: right">
12357</p>

   </td>
   <td><p style="text-align: right">
17.8</p>

   </td>
  </tr>
  <tr>
   <td>5800 x 5800
   </td>
   <td><p style="text-align: right">
255045</p>

   </td>
   <td><p style="text-align: right">
98579</p>

   </td>
   <td><p style="text-align: right">
2.6</p>

   </td>
   <td><p style="text-align: right">
14462</p>

   </td>
   <td><p style="text-align: right">
17.6</p>

   </td>
  </tr>
</table>


X - axis is duration in millisecond

Y - axis is testing condition rows x columns






![alt_text](/chart.png "image_tooltip")



## Conclusion

	In conclusion I found that a process program in multiple threads can reduce time of calculation. Execution will reduce more when the CPU has more cores with high clock speed.
