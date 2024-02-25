
Table acccount -> all the worker details\
Table role -> emplyee,manager...

Table availability -> what days and time xthe worker would like to work on, based on the time slots we congfire

Table shift  -> actual the shift the worker will work on \
note: start and end can be changed based on worker request

Table work_schedule -> schedule gathring all worker's shifts 

Table time_slot -> time frame the worker can choose to work \
Example: 10:00-12:00,12:00-14:00,14:00-16:00.... 

Table department -> represent the department the account work in 

Table work_schedule_configuration -> hold all the configuration needed for creating work schedule \
Example: amount of shift, what shift, start,from, account responsible.. 

Table shift_configuration -> hold all the configuration needed for creating work schedule, from the shift side \
Example: which timeslot,how many workers in that shift...

Relatins:
Ref: acccount.role_id > role.id \
Ref: acccount.account_id < availability.account_id \
Ref: acccount.account_id < availability.account_id \
Ref: acccount.department_id > department.id\
Ref: work_schedule.id < shift.work_schedule_id\
Ref: time_slot.id < availability.time_slot_id\
Ref: time_slot.id < shift_configuration.time_slot_id
Ref: work_schedule_configuration.department_id - department.id
Ref: work_schedule.department_id - department.id
Ref: shift_configuration.work_schedule_configuration_id> work_schedule_configuration.id

![ShiftManager (2)](https://github.com/yariv245/shift-manager/assets/6500992/efbc9fe1-a8da-456a-b819-aade40b0e94e)

// Use DBML to define your database structure
// Docs: https://dbml.dbdiagram.io/docs


work_schedule and shift visual
![demo](https://github.com/yariv245/shift-manager/assets/6500992/de2c64f7-a65f-498d-9d30-8ab2b53bdf04)

