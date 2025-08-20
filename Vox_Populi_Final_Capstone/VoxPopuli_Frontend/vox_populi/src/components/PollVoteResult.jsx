import { useParams } from "react-router";
import { useState, useEffect, useContext } from "react";
import { getPollResults, getPoll, getUserVoteOnPoll } from "../scripts/apicalls";
import UserContext from "../contexts/CreateUserContext";
import Loading from "./Loading";
import ErrorMessage from "./Error";

function PollVoteResult() {
    const { id } = useParams();
    const { userData } = useContext(UserContext);

    const [poll, setPoll] = useState(null);
    const [userVote, setUserVote] = useState(null);
    const [pollResults, setPollResults] = useState([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);

    // Attempt to parse id for poll.
    let pollId;
    try {
        pollId = parseInt(id);

        if (isNaN(pollId)) {
            throw new Error('Invalid ID format!')
        }
    } catch (error) {
        return ErrorMessage(error);
    }

    // Call API to get poll result.
    useEffect(() => {
        const loadPoll = async () => {
            try {
                const data = await getPoll(pollId);
                setPoll(data);
            } catch (err) {
                setError(err);
            }
        }

        const loadResults = async () => {
            try {
                const data = await getPollResults(pollId);
                setPollResults(data);
            } catch (err) {
                setError(err);
            }
        }

        const loadUsersVote = async () => {
            try {
                const data = await getUserVoteOnPoll(pollId, userData);
                setUserVote(data);
            } catch (err) {
                setError(err);
            }
        }
     
        loadPoll();
        loadResults();
        loadUsersVote();
        setLoading(false);
    }, []); // empty array, only run effect on first load

    if (error) {
        return ErrorMessage(error);
    }

    if (loading || !poll || !userData || !userVote) {
        return Loading();
    }



    return (
        <>
            <div className="container">
                <h3>{poll.pollTitle}</h3>
                <h5>{poll.pollDescription}</h5>
                <h6>You voted for: {userVote.optionName}</h6>
                {pollResults.map((option, i) => (
                    <p key={i}>{i + 1}: {option.optionName} - {option.optionVotes}</p>
                ))}
            </div>
        </>
    )
    
}

export default PollVoteResult;