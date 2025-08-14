class Account {
  constructor(accNum, bal) {
    this.accNum = accNum;
    this.bal = bal;
  }

  deposit(amount) {
    this.bal += amount;
    console.log(`Deposited Rs.${amount}. Current Balance is Rs.${this.bal}`);
  }

  withdraw(amount) {
    if (amount > this.bal) {
      console.log('Insufficient balance');
    } else {
      this.bal -= amount;
      console.log(`Withdrawn Rs.${amount}. Current Balance is Rs.${this.bal}`);
    }
  }
}

const account = new Account("100900", 1000);
account.deposit(25000);
account.withdraw(5000);
