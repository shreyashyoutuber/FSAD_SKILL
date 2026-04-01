import axios from "axios";
import { useEffect, useState } from "react";

function FakePostList() {

  const [posts, setPosts] = useState([]);
  const [filter, setFilter] = useState("");

  const fetchData = () => {
    axios.get("https://dummyjson.com/posts")
      .then(res => setPosts(res.data.posts));
  };

  useEffect(() => {
    fetchData();
  }, []);

  const filteredPosts = posts.filter(p =>
    filter ? p.userId === Number(filter) : true
  );

  return (
    <div>
      <h2>Fake API Posts</h2>

      <button onClick={fetchData}>Refresh</button>

      <br/><br/>

      <select onChange={(e)=>setFilter(e.target.value)}>
        <option value="">All Users</option>
        <option value="1">User 1</option>
        <option value="2">User 2</option>
        <option value="3">User 3</option>
      </select>

      {filteredPosts.map(p => (
        <div key={p.id}>
          <h4>{p.title}</h4>
          <p>{p.body}</p>
        </div>
      ))}

    </div>
  );
}

export default FakePostList;