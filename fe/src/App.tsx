import { useEffect } from 'react';
import './App.css';
import axios from 'axios';

function App() {
  useEffect(() => {

  }, []);

  async function call() {
    let i = 1;
    const interval = setInterval(() => {
      i++;
      if (i == 2000) {
        clearInterval(interval);
      }
      const response = axios.get('http://localhost:8080/auth/get-profile', {
        params: {
          userId: 100000
        }
      });
    }, 10);
  }

  async function call1() {
    for (let i = 1; i <= 1500; i++) {
      const response = axios.get('http://localhost:8080/auth/get-profile', {
        params: {
          userId: 100000
        }
      });
    }
  }

  return (
    <div className="App">
      <button onClick={call1}>call API</button>
    </div>
  );
}

export default App;
