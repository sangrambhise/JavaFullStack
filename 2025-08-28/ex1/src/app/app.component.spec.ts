import { AppComponent } from './app.component';

describe('AppComponent', () => {
  const app = new AppComponent();

  it('should return true for palindrome', () => {
    expect(app.isPalindrome('madam')).toBeTrue();
  });

  it('should return false for non-palindrome', () => {
    expect(app.isPalindrome('hello')).toBeFalse();
  });
});