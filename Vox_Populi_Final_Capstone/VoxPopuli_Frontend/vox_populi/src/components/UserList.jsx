import { useState, useEffect } from 'react'
import { getAllUsers } from '../scripts/apicalls';

function UserList() {
    const [users, setUsers] = useState([]);
    const [loading, setLoading] = useState(true);

    useEffect(() => {
        const fetchAllUsers = async () => {
            try {
                setLoading(true);
                const data = await getAllUsers();
                setUsers(data);
            } catch(err) {
                return;
            } finally {
                setLoading(false);
            }
        }

        fetchAllUsers();
    }, [])

    if (loading) {
        return (
            <div className="container mt-4">
                <div className="d-flex justify-content-center">
                    <div className="spinner-border" role="status">
                        <span className="visually-hidden">Loading...</span>
                    </div>
                </div>
            </div>
        )
    }

    return (
        <div className="container mt-4">
            <div className='row justify-content-center'>
                <div className="table-responsive">
                    <table className="table table-striped table-hover">
                        <thead className="table-dark">
                            <tr>
                                <th scope="col">User ID</th>
                                <th scope="col">Username</th>
                                <th scope="col">Password</th>
                                <th scope="col">Access Level</th>
                            </tr>
                        </thead>
                        <tbody>
                            {users.map((user) => (
                                <tr key={user.userId}>
                                    <td>{user.userId}</td>
                                    <td className="fw-bold">{user.username}</td>
                                    <td>{user.userPassword}</td>
                                    <td>                                    
                                        <span className="badge bg-secondary">
                                            {user.accessLevel}
                                        </span>
                                    </td>
                                </tr>
                            ))}
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    )
}

export default UserList;