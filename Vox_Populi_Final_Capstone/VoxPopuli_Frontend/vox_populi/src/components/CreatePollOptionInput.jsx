
function createPollOptionInput() {
    const maxOptionNameLength = 50;

    return (
        <input 
            name='optionName'
            className="form-control"
            type="text"
            maxLength={maxOptionNameLength}
        />
    ) 
}

export default createPollOptionInput