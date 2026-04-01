import { useEffect, useState } from "react";
import axios from "axios";

function StudentList({ setEditStudent }) {
  const [students, setStudents] = useState([]);

  const fetchData = () => {
    axios.get("http://localhost:8080/students").then((res) => setStudents(res.data));
  };

  useEffect(() => {
    fetchData();
  }, []);

  const deleteStudent = (id) => {
    axios.delete(`http://localhost:8080/students/${id}`).then(() => fetchData());
  };

  return (
    <div>
      <h2>Student List</h2>

      <table border="1">
        <thead>
          <tr>
            <th>Name</th>
            <th>Email</th>
            <th>Course</th>
            <th>Action</th>
          </tr>
        </thead>

        <tbody>
          {students.map((s) => (
            <tr key={s.id}>
              <td>{s.name}</td>
              <td>{s.email}</td>
              <td>{s.course}</td>
              <td>
                <button onClick={() => setEditStudent(s)}>Edit</button>
                <button onClick={() => deleteStudent(s.id)}>Delete</button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default StudentList;
