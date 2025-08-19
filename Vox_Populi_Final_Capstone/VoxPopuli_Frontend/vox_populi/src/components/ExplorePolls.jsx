import { useState, useEffect } from 'react';
import { getAllPollOverviews } from '../scripts/apicalls';


function ExplorePolls() {
    const [polls, setPolls] = useState([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);

    useEffect(() => {
        const fetchPolls = async () => {
            try {
                setLoading(true);
                const data = await getAllPollOverviews();
                setPolls(data);
            } catch (err) {
                setError(err);
            } finally {
                setLoading(false);
            }
        }
     
        fetchPolls();
    }, []); // empty array, only run effect on first load

    if (loading) {
        return (
            <div className="container mt-4">
                <div className="d-flex justify-content-center">
                    <div className="spinner-border" role="status">
                        <span className="visually-hidden">Loading...</span>
                    </div>
                </div>
            </div>
        );
    }

    if (error) {
        return (
            <div className="container mt-4">
                <div className="alert alert-danger" role="alert">
                    <h4 className="alert-heading">Error!</h4>
                    <p>Failed to fetch movie summaries: {error}</p>
                </div>
            </div>
        );
    }

    return (
        <>
            <div className='container'>
                <ol>
                    {polls.map((poll) => (
                        <div className='card mt-4' key={poll.pollId}>
                            <div className='card-body'>
                                <div className='d-flex gap-2'>
                                    <h5 className='card-title'>{poll.pollTitle} </h5>
                                    <span className='card-text'>
                                        <small className='text-muted'> By: {poll.pollAuthorUsername}</small>
                                    </span>
                                </div>
                                <h6 className='card-subtitle mb-2 text-muted'>{poll.pollDescription}</h6>
                                <p className='card-text'><small className='text-muted'>Votes: {poll.votesOnPoll}</small></p>
                            </div>
                        </div>
                        ))}
                </ol>
            </div>
        </>
    )
}

export default ExplorePolls;