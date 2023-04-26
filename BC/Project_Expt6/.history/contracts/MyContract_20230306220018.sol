pragma solidity ^0.8.0;

contract MyContract {
    uint private number;

    constructor() {
        number = 42;
    }

    function getNumber() public view returns (uint) {
        return number;
    }
}
