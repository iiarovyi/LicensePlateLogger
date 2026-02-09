# Background
The very similar task was given during technical interview to one of the companies I wanted to work for.
During the interview I was not able to solve the issues either due to stress, unfamiliar tools or maybe because my most recent background was JavaScript-based so java stack traces got me little confused :)
Hence I spent some time (check git log) to get the solutions and gain some practice.

# Exercise description:

We have a tall road with multiple tall booths on the way, schematically

```text
<--- West direction

   Exit                    Pass                         Entry
    |                        |                           |
---------------------------------------------------------------------------

- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

---------------------------------------------------------------------------
    |                        |                           |
   Entry                    Pass                        Exit

East direction ---->    
```

Booths are registering the car license plate when it passes by, creating a record in a log file.
Example of log file can be found in resources. Example record:

```aiignore
1770576603506   TNT123XT    EXIT    89.1234,123.3717    E
```

where:
* 1770576603506 - timestamp
* TNT123XT - license plate number
* EXIT - booth type that created the log entry
* 89.1234,123.3717 - coordinates of the booth
* E - direction of the trip


The code presented in this repo provides the possibility to read such logs from multiple data sources. And most of the functionality is verified by test files.
For database as a source, there is a script to create respective tables, relations and several records.

# From the things I was considering to do next was:
[ ] write a simulator to simulate some traffic and ensure that at constant places for vehicles of different velocities it creates records correctly (assuming that velocity is const and movement is linear).
This kind of task can be solved having each vehicle as a separate runnable.

But YAGNI prevents me from doing that now. So should I?