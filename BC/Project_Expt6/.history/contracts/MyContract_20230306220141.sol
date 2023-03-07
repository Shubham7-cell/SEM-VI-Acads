pragma solidity ^0.8.0;

contract MyContract {
    uint256 private number;

    constructor() {
        number = 42;
    }

    function getNumber() public view returns (uint256) {
        return number;
    }
}
