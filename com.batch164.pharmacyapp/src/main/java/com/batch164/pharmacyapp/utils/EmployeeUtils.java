package com.batch164.pharmacyapp.utils;

import com.batch164.pharmacyapp.model.Employee;
import com.batch164.pharmacyapp.model.RoleType;
import com.batch164.pharmacyapp.utils.dao.EmployeeDAO;

import java.sql.Connection;

public class EmployeeUtils
{
//  Indicate the current user is a manager, or a supervisor, or a staff:
//  Get supervisorID of the current employee:
//  1. If the supervisorID is null, it means the current employee is a manager,
//      so we go to the  "manager-view" scene.
//  2. If the supervisorID is not null,
//      we continue get supervisorID of the current employee's supervisor.
//      And we have two cases:
//      2.1 If the supervisorID of the current employee's supervisor is null,
//        it means the current employee is a supervisor,
//        so we go to the "supervisor-view" scene.
//      2.2 If the supervisor ID of the current employee's supervisor is not null,
//        it means the current employee is a staff,
//        so we go to the "staff-view" scene.
  public static RoleType indicateRoleOfUser(Employee currentUser, Connection connection)
  {
    String tempSupervisorID =
        EmployeeDAO.getSupervisorID(connection, currentUser.getId());
    if (tempSupervisorID == null) // The current user is a manager
    {
      return RoleType.MANAGER;
    }
    else
    {
      String tempHigherSupervisorID =
          EmployeeDAO.getSupervisorID(connection, tempSupervisorID);
      if (tempHigherSupervisorID == null) // The current user is a supervisor
      {
        return RoleType.SUPERVISOR;
      }
      else // The current user is a staff
      {
        return RoleType.STAFF;
      }
    }
  }
}
