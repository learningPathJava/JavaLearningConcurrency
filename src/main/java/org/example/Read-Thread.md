# Thread ciclu de viata

#### Starea - "New Thread"
* Nu are alocate resurse
* Putem apela `start`
* `IllegalThreadStateException`
```java
Thread fir = new Thread(obiect);
// firul se gaseste in starea "New Thread"
```

#### Starea "Runnable"
* Alocare resurse
* Planificare la proces
* Apel `run`
```java
fir.start()
// firul se gaseste in starea "Runnable"
```

#### Starea "Not Runnable"
* `sleep`
* `wait` - `notify`
* Operatii blocante I/O
```java
try {
    Thread.sleep(1000);
    // firul este in sleep pentru o secunda
} catch (InterruptedException e) {  
    // InterruptedException when an another thread interrupts this thread
    LOGGER.error("Interrupted!", e);
    // Restore interrupted state...
    Thread.currentThread().interrupt();
}
```

#### Starea "Dead"
* Nu exista starea stop. 
* Firele trebuie sa se termine "natural".
```java
public void run() {
    // Something
}
```

#### Variabile de terminare
```java
public boolean executie = true;
public void run() {
    while (executie) {
        ...
    }
}
```

#### System.exit
* termina fortat toate firele de executie.

#### Metoda isAlive
* `true` - ”Runnable” sau ”Not Runnable”
* `false` - ”New Thread” sau ”Dead”

```java
NumaraSecunde fir = new NumaraSecunde();
// isAlive retuneaza false
// (starea este New Thread)
fir.start();
// isAlive retuneaza true
// (starea este Runnable)
fir.executie = false;
// isAlive retuneaza false
// (starea este Dead)
```

# Fire de executie de tip ”daemon”

        Daemon = fir de excutie care se termina automat la terminarea aplicatiei.
        
        Un proces este considerat in executie daca acesta contine cel putin un fir
        de executie activ.

#### Metoda `setDaemon`
Permite transformarea unui fir de executie in daemon sau invers.

# Planificarea la executie
* Proces
* Fir de executie
* Planificator
* Procesor fizic

## `Prioritati de executie`
Modele de lucru
* Modelul cooperativ
    * partajare `timp`
* Modelul preemtiv - "cuante de timp"
    * partajare `resurse`

## `setPriority`
```
MAX_PRIORITY = 10;
MIN_PRIORITY = 1;
NORM_PRIORITY= 5;
```
Un fir de executie cedeaza procesorul:
* prioritate mai mare
* metoda sa `run` se termina
* `yield`
* timpul alocat a expirat

# Sincronizarea firelor de executie
* Partajarea resurselor comune
* Asteptarea indeplinirii unor conditii

# Scenariul producator / consumator

# 