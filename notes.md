# Table of Content

1. [Chapter One](#chapter-one-introduction-to-operating-systems)
2. [Chapter Two](#chapter-two-operating-system-structure)

# **Chapter One: Introduction to Operating Systems**

## What is an Operating System?

An **Operating System (OS)** is a program that serves as an intermediary between the user and the computer hardware.

### Main Goals of an OS:

- Execute user programs and assist with solving problems.
- Provide a convenient and user-friendly environment.
- Utilize hardware resources efficiently.
- Ensure good performance and ease of use.

### Key Definitions:

- The **kernel** is the core component of the OS and is *“the one program always running.”*
- Everything else is classified as:
    - **System programs**: Included with the OS (e.g., file managers, compilers).
    - **Application programs**: Used to perform specific user tasks (e.g., web browsers).

---

## Components of a Computer System

A modern computer system is divided into four components:

1. **Hardware** – The physical components: CPU, memory, and I/O devices.
2. **Operating System** – Manages hardware and coordinates resources.
3. **Application Programs** – Software that solves user problems (e.g., spreadsheets, compilers).
4. **Users** – End users, machines, or other systems.

---

## System Initialization

### Bootstrap Program:

- Loaded during power-up or reboot.
- Stored in **firmware** (e.g., ROM or EPROM).
- Initializes hardware and loads the **OS kernel** into memory to start execution.

---

## System Operation and Interrupts

### CPU and I/O Interaction:

- CPU and I/O devices share a **system bus** to access **shared memory**.
- Each **device controller** manages a specific hardware device and contains a **local buffer**.
- The CPU moves data between main memory and these buffers.

### Interrupts:

- Devices inform the CPU that an operation has completed via **interrupts**.
- The **interrupt vector** maps to specific service routines.
- A **trap** or **exception** is a software-generated interrupt (e.g., caused by a divide-by-zero error or a system call).
- The operating system is **interrupt-driven**.

### Types of Interrupts:

- **Polling** – The CPU checks each device regularly (inefficient).
- **Vectored** – The device sends a specific interrupt signal to the CPU (more efficient).

### Dual-Mode Operation:

- **User Mode**: Limited access; used for executing user applications.
- **Kernel Mode**: Full access; used by the OS for critical operations.
- Mode transitions protect system integrity and prevent user programs from interfering with the OS.
- Switching from user to kernel mode occurs during a **system call** or **exception**, and returns to user mode once the task is handled.

---

## Performance Optimization

### Caching:

- Frequently accessed data is copied to **faster memory** (cache) to improve performance.
- Main memory (RAM) often serves as a cache for secondary storage (e.g., hard drives).

### Device Drivers:

- Each device controller uses a **device driver** to communicate with the OS.
- Drivers provide a **uniform interface**, abstracting hardware-specific details.

---

## System Architectures

### Multiprocessor Systems:

- Also called **parallel systems** or **tightly-coupled systems**.
- Contain two or more CPUs working together.
- Benefits include:
    - Increased reliability (fault tolerance).
    - Cost efficiency (economy of scale).
    - Higher throughput and performance.

### Types:

- **Asymmetric Multiprocessing**: Each processor performs a specific task.
- **Symmetric Multiprocessing**: All processors perform all tasks equally.

---

## Clustered Systems

Clustered systems consist of multiple computers connected together to function as a unified system.

### Key Features:

- Share storage through a **Storage Area Network (SAN)**.
- Provide **high availability**, continuing operation even if one system fails.

### Types of Clustering:

- **Asymmetric Clustering**: One node is in standby mode, ready to take over on failure.
- **Symmetric Clustering**: All nodes are active and monitor each other.

### High-Performance Computing (HPC):

- Used in scientific or complex tasks requiring high processing power.
- Applications must be written to support **parallelization**.

### Distributed Lock Manager (DLM):

- Prevents conflicting operations by managing resource access across clustered systems.

---

## Interrupt Handling Overview

| Type | Description |
| --- | --- |
| Hardware | Triggered by physical devices (e.g., keyboard, disk I/O). |
| Software | Triggered by exceptions or system calls during execution. |

The system transitions from **user mode** to **kernel mode** to safely handle these interrupts and system requests

---

## **Operating System Structure**

- **Multiprogramming**: Keeps the CPU busy by having multiple jobs (programs) in memory. When one job needs to wait (like for input), the OS switches to another job.
- **Timesharing (Multitasking)**: The OS quickly switches between jobs so users can interact with each one as if it's running alone.
- Each user has at least one **process** in memory.
- If memory is full, the OS swaps processes in and out (called **swapping**).
- **Virtual memory** allows running programs that don’t fully fit in RAM by moving parts in and out of memory.

---

## **Operating System Operations**

- OS is **interrupt-driven**:
    - **Hardware interrupts**: from devices like a keyboard or disk.
    - **Software interrupts (traps)**: from errors or user requests.
- **Dual-mode operation**:
    - **User mode**: limited access (regular apps).
    - **Kernel mode**: full access (OS-level).
    - Mode bit helps the OS know which mode it's in.
    - Some instructions are only allowed in kernel mode for safety.

---

## **Timer**

- Used to **prevent programs from running forever** (infinite loop).
- The OS sets a countdown (timer), and when it reaches zero, an interrupt is triggered so the OS can take control again.

---

## **Process Management**

- A **process** is a program that's running.
- A program (like a file) is inactive, but a process is active.
- It needs resources: memory, CPU time, input/output, etc.
- When a process ends, the OS takes back the resources.
- **Single-threaded** process: one task at a time.
- **Multi-threaded**: can do multiple things at once.
- Multiple processes can run at the same time using **CPU scheduling**.

### Key OS responsibilities:

- Start and end processes.
- Pause and continue processes.
- Help processes **talk to each other** and avoid **conflicts** (deadlocks).

---

## **Memory Management**

- Programs and data must be in memory (RAM) to run.
- The OS decides:
    - What should be in memory.
    - When to move things in or out.
    - Who gets how much memory.
- Goal: keep memory use efficient and responsive.

---

## **Storage Management**

- OS presents a logical view of storage as **files**.
- Manages devices like hard drives and SSDs.
- Files are usually in **directories** (folders).
- Handles:
    - Creating/deleting files.
    - Reading/writing files.
    - Controlling who can access what.
    - Backups to keep files safe.

---

## **Mass Storage Management**

- For long-term storage (data that doesn’t fit in memory).
- Uses **disks** for storing large amounts of data.
- The OS handles:
    - Managing free space.
    - Deciding where to store files.
    - **Scheduling** disk access to avoid delays.

---

## **I/O Subsystem**

- The OS hides hardware complexity from users.
- Uses:
    - **Buffering**: store data temporarily.
    - **Caching**: save frequent data for faster access.
    - **Spooling**: run input/output tasks in the background.
- Uses **device drivers** to talk to hardware.

---

## **Protection and Security**

- **Protection**: Controls what each program/user can access.
- **Security**: Defends the system against threats like viruses or hackers.
- Each user has a unique ID. Files and processes are tagged with these IDs to control access.
- **Groups** allow shared access rights.
- **Privilege escalation** lets certain users do more (like an admin).

---

## **Kernel Data Structures**

The OS uses data structures to manage resources:

- **Linked lists** (singly, doubly, circular)
- **Binary trees** (regular and balanced for faster search)
- **Hash tables** for fast lookups
- **Bitmaps** to track which resources are in use

---

## **Computing Environments**

### 1. **Traditional**

- Regular PCs or laptops.
- Connected to networks like the Internet.
- May include firewalls or portals for access.

### 2. **Mobile**

- Smartphones and tablets.
- Added features like GPS, sensors, etc.
- Run mobile OSes like iOS or Android.

### 3. **Distributed**

- A group of computers connected over a network.
- Work together and look like a single system.
- Communicate using **TCP/IP** (Internet protocol).

### 4. **Client-Server**

- Clients (like your browser) request services from servers.
- Server types:
    - **Compute server**: handles tasks like databases.
    - **File server**: stores and shares files.

### 5. **Peer-to-Peer (P2P)**

- No fixed server or client.
- All nodes (devices) are equal.
- Examples: Skype, file-sharing apps like BitTorrent.

### 6. **Virtualization**

- Run multiple OSes on one computer.
- Example: Running Windows inside macOS.
- Uses **Virtual Machine Managers (VMM)** like VirtualBox or VMware.

### 7. **Cloud Computing**

- Offers services over the Internet:
    - **SaaS** (Software): Google Docs.
    - **PaaS** (Platform): Firebase.
    - **IaaS** (Infrastructure): AWS storage.
- Can be **public**, **private**, or **hybrid** clouds.
- Needs extra security (like firewalls) and tools (like load balancers).

### 8. **Real-Time Embedded Systems**

- Computers built into devices (cars, microwaves, etc.).
- Some run real-time operating systems (RTOS) where tasks must finish on time.
- Example: An airbag must trigger exactly when needed.

---

## **Open-Source Operating Systems**

- Anyone can see and change the code.
- Encourages freedom and learning.
- Examples: Linux, BSD (base of macOS).
- Tools like VirtualBox let you run these OSes for testing and exploration.

---

# **Chapter Two: Operating System Structure**

## Operating System Services

An **Operating System (OS)** provides the environment in which programs run. It offers services to both users and the system. These services fall into two main categories:

### 1. Services for Users and Programs

These services make it easier and safer to run applications.

**User Interface (UI)**

- Most operating systems provide a **Graphical User Interface (GUI)** using windows, icons, and a mouse.
- A **Command-Line Interface (CLI)** allows users to type in commands directly.
- **Touch-screen interfaces** are common on mobile devices and allow input through gestures.
- Many systems offer two or all three types of interfaces.

**Program Execution**

- The OS must:
    - Load programs into memory
    - Execute them
    - Terminate them either normally (successful execution) or abnormally (due to an error)

**I/O Operations**

- Programs often need to interact with input/output devices such as disks, printers, or networks.
- For efficiency and security, users do not directly control devices.
- The OS provides controlled access to these resources.

**File-System Manipulation**

- Programs and users may:
    - Read, write, create, and delete files and directories
    - Search for files and list their information
    - Set or manage permissions to control access
- Many systems support multiple file systems for performance or compatibility.

**Communication Between Processes**

Two main methods are used:

- **Shared Memory**: Processes read and write to the same area of memory.
- **Message Passing**: Information is packaged and transferred between processes by the OS.

These methods support communication between processes on the same system or across a network.

**Error Detection**

- The OS constantly monitors for errors in:
    - Hardware (e.g., memory or disk issues)
    - I/O devices (e.g., printer or network errors)
    - Programs (e.g., illegal memory access, divide-by-zero)
- Depending on the error, the OS may shut down a process, return an error code, or take corrective action.

---

### 2. Services for System Management and Efficiency

These services focus on managing resources and ensuring system reliability.

**Resource Allocation**

- When multiple programs run at the same time, the OS allocates CPU time, memory, storage, and I/O devices.
- Special routines (e.g., CPU scheduling) determine how resources are assigned.

**Accounting (Logging)**

- Tracks resource usage by each program or user.
- Useful for:
    - System performance analysis
    - Billing in multi-user environments
    - System configuration and planning

**Protection and Security**

- Ensures that processes do not interfere with each other or the OS.
- Includes:
    - **Authentication**: Users must prove their identity (e.g., with a password).
    - **Authorization**: Control over what each user or process can access.
    - **Security**: Protects the system from external threats or unauthorized access.

![a view of operating system services](attachment:6c880b72-c6ee-4ef9-88e1-5857bdfac38f:image.png)

a view of operating system services

Operating systems offer different ways for users to interact with them. There are **three main types of interfaces**:

---

### 1. **Command-Line Interface (CLI)**

- Also called a **command interpreter** or **shell**.
- Lets users type commands directly.
- Common in systems like **Linux, UNIX, and Windows**.
- Examples of shells: **C shell, Bash (Bourne-Again shell), Korn shell**.

### How it works:

- Some commands are **built into the shell**, meaning the shell knows what to do.
- Others use **system programs**. The shell simply **runs a file** with the command's logic (e.g., `rm file.txt` runs the `rm` program).
- This design makes it **easy to add new commands** without changing the shell itself.

### 2. **Graphical User Interface (GUI)**

- Uses **windows, icons, and menus** instead of typing.
- Users click on **icons** or **folders** using a mouse.
- Common in operating systems like **macOS, Windows, and Linux** with GUIs like **GNOME and KDE**.
- Originated from research at **Xerox PARC** in the 1970s and became popular with the **Apple Macintosh** in the 1980s.
- GUIs are more **visual and beginner-friendly**.

### 3. **Touch-Screen Interface**

- Used in **smartphones and tablets**.
- Users interact by **tapping, swiping, or pinching** the screen.
- Replaces the need for physical keyboards or mice.
- Example: **iPhone and iPad use the Springboard interface**.

## **Choosing an Interface**

- **Power users** and **system administrators** prefer the **command-line** because it’s faster and supports **automation** through **shell scripts** (saved command steps).
- **Most everyday users** prefer **GUIs** because they’re easier and more visual.
- Some tasks are only available via CLI, especially on UNIX/Linux systems.
- **macOS now supports both**: the Aqua GUI and a command line (because it’s built on a UNIX kernel).
- **Mobile systems** rarely use command lines—almost everything is done through **touch**.

## System Calls

System calls are how a **program communicates with the operating system (OS)** to request services like reading a file, creating a new process, or writing to the screen. They form the **interface between a running program and the OS kernel**.

System calls are usually accessed through **functions in high-level languages** like C or C++. Low-level tasks might require **assembly language**.

Mostly accessed by programs via a high-level **Application Programming Interface (API)** rather than direct system call use

---

## Real-World Example: Copying a File

A simple program that copies one file to another uses **multiple system calls**, including:

- Reading input/output file names (e.g., through user input or GUI)
- Opening files (error checks needed)
- Reading from the input file
- Writing to the output file
- Handling errors (e.g., file not found, disk full)
- Closing files and exiting

Even this simple task shows how **heavily programs rely on system calls**.

---

## Application Programming Interface (API)

- Most programmers don’t directly write system calls.
- Instead, they use **APIs** like:
    - **Win32 API** (Windows)
    - **POSIX API** (Linux/macOS)
    - **Java API** (for JVM programs)

APIs **abstract away system call details**, making programs more portable and easier to write. Internally, APIs **call system functions** behind the scenes.

**Example:**

`printf()` → calls `write()` system call via the **C standard library (libc)**

---

## How System Calls Work

System calls go through a **system-call interface**, which:

1. Passes the request from user mode to kernel mode.
2. Uses a **system call number** to find the correct function in the system call table.
3. Executes the function in kernel mode and returns results.

---

## Parameter Passing

System calls often need input parameters. There are three main ways to pass them:

1. **Registers** – Fastest but limited to a few parameters.
2. **Memory block/table** – A structure with parameters; passed via register. Used by Linux.
3. **Stack** – Parameters are pushed onto the stack.

---

## Major Categories of System Calls

| **Category** | **Common System Calls** |
| --- | --- |
| **Process Control** | `create_process()`, `exit()`, `fork()`, `exec()` |
| **File Management** | `open()`, `read()`, `write()`, `close()` |
| **Device Management** | `request_device()`, `release_device()`, `ioctl()` |
| **Information Maintenance** | `get_time()`, `set_time()`, `get_system_info()` |
| **Communications** | `send_message()`, `receive_message()`, `pipe()`, `mmap()` |
| **Protection** | `get_permissions()`, `set_permissions()`, `allow_user()` |

---

## Examples: Windows vs UNIX System Calls

| **Action** | **Windows** | **UNIX/Linux** |
| --- | --- | --- |
| Create process | `CreateProcess()` | `fork()`, `exec()` |
| Read file | `ReadFile()` | `read()` |
| Set permissions | `SetFileSecurity()` | `chmod()` |

---

## Interprocess Communication (IPC)

**Two models:**

1. **Message Passing**
    - Processes exchange messages.
    - Good for small data transfers.
    - Easier for distributed systems (e.g., over a network).
2. **Shared Memory**
    - Processes access the same memory area.
    - Fastest method but needs synchronization (e.g., using locks).

Common system calls:

- `open_connection()`, `accept_connection()`
- `shared_memory_create()`, `shared_memory_attach()`

---

## Device and File Management

- OS treats physical devices and files similarly.
- Common calls: `read()`, `write()`, `open()`, `close()`
- Devices might require exclusive access via `request_device()` and `release_device()`.

---

## Debugging and Maintenance

- System calls like `dump_memory()` and tools like `strace` help track system call usage.
- Time profiling and logging help optimize performance.

---

## Special Platforms

**Arduino (Single-tasking):**

- Uses a bootloader, no OS.
- Only one program (sketch) runs at a time.

**FreeBSD (Multitasking):**

- Uses `fork()` and `exec()` to run multiple programs at once.
- Allows background processes, priority control, and shell interaction.

---

## Summary of Key Terms

| **Term** | **Definition** |
| --- | --- |
| **System Call** | Software interrupt requesting OS services |
| **API** | Developer-friendly interface for OS services |
| **System Call Interface** | Links user functions to system calls |
| **Stack** | Memory structure for passing parameters |
| **Daemon** | Background service process |
| **Client/Server** | Model for communication between processes |
| **Shared Memory** | Memory accessible by multiple processes |
| **Message Passing** | Communication via structured messages |
| **Protection** | Controls access to system resources |