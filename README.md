# User Guide

**Welcome to Bob's User Guide.** <br>
Bob, your friendly Chat Bot, is a **destop app for managing your tasks**. He can add, delete, and mark your tasks as completed as long 
as you ask him to. 
>**Learn more about his features below**.

## Features 
**:information_source: Note about the command format:** <br>

* Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  e.g. in `todo DESCRIPTION`, `DESCRIPTION` is a parameter which can be used as `add homework`.
<br>
<br>
### Adding a todo-task: `todo`
Adds a todo task to the task list.

Format: `todo DESCRIPTION`

Example of usage:
 
`todo homework`

Expected outcome: 

An uncompleted todo task `homework`, marked with a cross, will be added to your task list. 

### Adding a deadline-task: `deadline`
Adds a deadline task to the task list.

Format: `deadline DESCRIPTION /by DATE TIME` 

>DATE format: `YYYY/MM/HH` 

>TIME format: `HHMM` *(in 24-hour format)*

Example of usage:
 
`deadline homework /by 2020/09/15 2359`

Expected outcome: 

An uncompleted deadline task `homework`, marked with a cross, with given date and time will be added to your task list. 

### Adding an event-task: `event`
Adds an event task to the task list.

Format: `event DESCRIPTION /at DATE TIME`

>DATE format: `YYYY/MM/HH` 

>TIME format: `HHMM` *(in 24-hour format)*

Example of usage:
 
`event dinner /at 2020/09/15 1900`

Expected outcome: 

An uncompleted event task `dinner`, marked with a cross, with given date and time will be added to your task list. 

### Marking task as completed: `done`
Marks a task in the task list as done.

Format: `done TASK_NUMBER`

Example of usage:
 
`done 1`

Expected outcome: 

The task with task number `1` on the task list will be marked as done with a tick. 

### Deleting a task: `delete`
Deletes a task in the task list.

Format: `delete TASK_NUMBER`

Example of usage:
 
`delete 1`

Expected outcome: 

The task with task number `1` on the task list will be deleted. 

### Listing tasks: `list`
Lists all the tasks in the task list.

Format: `list`

### Finding tasks: `find`
Finds all the tasks containing the given keyword in the task list.

Format: `find KEYWORD`

Example of usage:
 
`find work`

Expected outcome: 

Every task in the task list containing `work` in its description will be shown.

### Undoing commands: `undo`
Reverts the state of task list to before the previous command.

Format: `undo`

Possible commands to undo: `todo`, `deadline`, `event`, `done`, `delete` 


### Exiting Bob: `exit`
Exits the program.

Format: `exit`

## Usage


## Command Summary
Action            | Format, Examples
------------------|---------------------------------
Add todo task     | `todo DESCRIPTION` <br> e.g.: `todo homework`
Add deadline task | `deadline DESCRIPTION /by DATE TIME` <br> e.g.: `deadline homework /by 2020/09/15 2359`
Add event task    | `event DESCRIPTION /at DATE TIME` <br> e.g.: `event dinner /at 2020/09/15 1900`
Done              | `done TASK_NUMBER` <br> e.g.: `done 1`
Delete            | `delete TASK_NUMBER` <br> e.g.: `delete 1`
List              | `list`
Find              | `find KEYWORD` <br> e.g.: `find work`
undo              | `undo`
Exit              | `exit`