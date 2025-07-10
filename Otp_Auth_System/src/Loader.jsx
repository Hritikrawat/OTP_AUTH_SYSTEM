import React from 'react';
import './Loader.css';

function Loader() {
  return (
    <div className="spinner-container">
      <div className="loading-spinner"></div>
      <p>Sending OTP...</p>
    </div>
  );
}

export default Loader;
