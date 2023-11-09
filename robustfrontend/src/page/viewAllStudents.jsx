import { useEffect, useState } from "react";
import axios from "axios";

function AllStudents() {
  const [students, setStudents] = useState([]);

  const fetchData = async () => {
    axios
      .get("http://localhost:8080/student/get")
      .then((response) => setStudents(response.data))
      .catch((error) => {
        console.log(error);
      });
  };

  useEffect(() => {
    fetchData();
  }, []);

  return (
    <div>
      {students.map((student, index) => (
        <div>
          Id: {student.id} <br />
          Name: {student.name} <br />
          Department: {student.department} <br />
          Address: {student.address} <br />
        </div>
      ))}
    </div>
  );
}
export default AllStudents;
