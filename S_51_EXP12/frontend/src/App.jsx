import { useState } from "react";
import StudentList from "./components/StudentList";
import AddStudent from "./components/AddStudent";

function App() {
  const [editStudent, setEditStudent] = useState(null);
  const [refresh, setRefresh] = useState(false);

  const reload = () => setRefresh(!refresh);

  return (
    <div>
      <AddStudent editStudent={editStudent} setEditStudent={setEditStudent} refresh={reload} />
      <StudentList setEditStudent={setEditStudent} key={refresh} />
    </div>
  );
}

export default App;
