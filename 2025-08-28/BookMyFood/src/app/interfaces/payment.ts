export interface IPayment {
  orderId: string;
  totalOrderPrice: number;
  paymentStatus: number;
  modeOfPayment: string;
  accountNumber: string;
  cvv: number;
}