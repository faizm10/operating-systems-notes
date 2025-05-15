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