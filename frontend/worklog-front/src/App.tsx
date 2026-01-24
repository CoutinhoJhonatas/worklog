import { useEffect, useState } from 'react';
import { fetchSessions } from './services/worklogApi';
import type { WorkSession } from "./types/WorkSession";

function App() {
  const [sessions, setSessions] = useState<WorkSession[]>([]);
  const [loading, setLoading] = useState<boolean>(true);

  useEffect(() => {
    fetchSessions()
      .then(setSessions)
      .finally(() => setLoading(false));
      console.log(sessions);
  }, []);

  if (loading) {
    return <p>Loading sessions...</p>
  }

  return (
    <>
      <div style={{ padding: 24 }}>
      <h1>Worklog</h1>

      <ul>
        {sessions.map((session) => (
          <li key={session.id} style={{ marginBottom: 12 }}>
            <strong>{session.title}</strong>
            <div>{session.category}</div>
            <div>
              {session.durationInMinutes
                ? `${session.durationInMinutes} min`
                : session.startAt}
            </div>
            <div>
              {session.tags}
            </div>
          </li>
        ))}
      </ul>
    </div>
    </>
  )
}

export default App
