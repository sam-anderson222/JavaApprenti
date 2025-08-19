function ErrorMessage(error) {
    return (
            <div className="container mt-4">
                <div className="alert alert-danger" role="alert">
                    <h4 className="alert-heading">Error!</h4>
                    <p>Failed to fetch: {error.toString()}</p>
                </div>
            </div>
        );
}

export default ErrorMessage