import { BitcoinLocalMerchantPage } from './app.po';

describe('bitcoin-local-merchant App', () => {
  let page: BitcoinLocalMerchantPage;

  beforeEach(() => {
    page = new BitcoinLocalMerchantPage();
  });

  it('should display welcome message', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('Welcome to app!!');
  });
});
