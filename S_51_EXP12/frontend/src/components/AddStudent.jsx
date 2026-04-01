import { useState, useEffect } from "react";
import axios from "axios";

function AddStudent({ editStudent, setEditStudent, refresh }) {
  const [form, setForm] = useState({
    name: "",
    email: "",
    course: ""
  });

  useEffect(() => {
    if (editStudent) {
      setForm(editStudent);
    }
  }, [editStudent]);

  const handleChange = (e) => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  const submit = () => {
    if (form.id) {
      axios.put(`http://localhost:8080/students/${form.id}`, form).then(() => {
        setEditStudent(null);
        setForm({ name: "", email: "", course: "" });
        refresh();
      });
    } else {
      axios.post("http://localhost:8080/students", form).then(() => {
        setForm({ name: "", email: "", course: "" });
        refresh();
      });
    }
  };

  return (
    <div>
      <h2>Add / Update Student</h2>

      <input name="name" value={form.name} onChange={handleChange} placeholder="Name" />
      <input name="email" value={form.email} onChange={handleChange} placeholder="Email" />
      <input name="course" value={form.course} onChange={handleChange} placeholder="Course" />

      <button onClick={submit}>Submit</button>
    </div>
  );
}

export default AddStudent;
