# java-threading
Java multi threading concepts

Race condition - Multiple threads trying to access (racing towards) a shared location at te same time<br/>

Strategies to resolve
1. Confinement
2. Immutability
3. Synchronization  (we may run into deadlock)
4. Atomic Objects
5. Partitioning
    
Visibility problem - Modifications on shared location by one thread is ot visible to other threads
1. Volatile