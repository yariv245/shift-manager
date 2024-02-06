
Table acccount -> all the worker details\
Table role -> emplyee,manager...

Table availability -> what days and time xthe worker would like to work on, based on the time slots we congfire\

Table shift  -> actual the shift the worker will work on \
note: start and end can be changed based on worker request\

Table work_schedule -> schedule gathring all workr's shifts \

Table time_slot -> time frame the worker can chosr to work \
Example: 10:00-12:00,12:00-14:00,14:00-16:00.... \

Relatins:
Ref: acccount.role_id > role.id \
Ref: acccount.account_id < availability.account_id \
Ref: acccount.account_id < shift.account_id\
Ref: work_schedule.id < shift.work_schedule_id\
Ref: time_slot.id < availability.time_slot_id\

![ShiftManager](https://github.com/yariv245/shift-manager/assets/6500992/f7a5e719-53a3-49fa-b173-2c15d1fba975)

// Use DBML to define your database structure
// Docs: https://dbml.dbdiagram.io/docs
