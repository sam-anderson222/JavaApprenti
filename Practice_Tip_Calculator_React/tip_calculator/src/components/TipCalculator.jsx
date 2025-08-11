import { useState } from 'react';

function TipCalculator() {
    // State Variables
    const [bill, setBill] = useState('');
    const [tipPercentage, setTipPercentage] = useState(0);

    // Calculates the bill total
    const calculateTotal = () => {
        const billNum = parseFloat(bill);
        const tipPercentageNum = parseFloat(tipPercentage);

        if (!isNaN(billNum) && !isNaN(tipPercentageNum) && tipPercentageNum >= 0 && billNum > 0) {
            return billNum + (billNum * (tipPercentage / 100));
        }

        return null;
    };

    const finalTotal = calculateTotal();

    return (
        <div className="card shadow mb-4">
            <div className="card-body">
                <h2 className="card-title text-center mb-4">Tip Calculator</h2>
                
                {/* Bill Input */}
                <div className="mb-3">
                <label className="form-label">Bill</label>
                <div className="input-group">
                    <span className="input-group-text">$</span>
                    <input
                    type="number"
                    className="form-control"
                    placeholder="Enter bill"
                    value={bill}
                    onChange={(e) => setBill(e.target.value)}
                    />
                </div>
                </div>

                {/* Tip Percent Input */}
                <div className="mb-3">
                <label className="form-label">Width</label>
                <div className="input-group">
                    <span className="input-group-text">%</span>
                    <input
                    type="number"
                    className="form-control"
                    placeholder="Enter tip percent"
                    value={tipPercentage}
                    onChange={(e) => setTipPercentage(e.target.value)}
                    />
                </div>
                </div>

                {/* Live Results Display */}
                <div className="alert alert-success text-center">
                <h4 className="mb-0">
                    Total: <span className="text-success"> $</span>{finalTotal !== null ? finalTotal.toFixed(2) : 0}
                </h4>
                <small className="text-muted">Updates automatically as you type</small>
                </div>
            </div>
        </div>
    );
}

export default TipCalculator;